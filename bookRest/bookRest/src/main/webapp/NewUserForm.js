var newUser = Backbone.Model.extend({
	urlRoot : "webapi/client"
});
var n = new newUser();
var newUserView = Backbone.View
		.extend({
			initialize : function() {
				this.render();
			},
			render : function() {
				var temp = _.template($("#newUserForm").html(), {});
				this.$el.html(temp);
			},
			events : {
				"submit #newUser" : function() {
					n.set({
						firstName : $("#fname").val(),
						lastName : $("#lname").val(),
						emailID : $("#email").val(),
						password : $("#pass").val(),
						phoneNo : $("#phn").val(),
					});
					if (n.save()) {
						alert("User created successfully");
					} else {
						alert("Oops there is some issue with server plaese try after sometime");
					}
				}

			}

		});