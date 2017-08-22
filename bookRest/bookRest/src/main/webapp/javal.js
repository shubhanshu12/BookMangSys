var login = Backbone.Model.extend({
	// urlRoot: function(){return
	// "webapi/client+?uname="+this.uname+"+&+password="+this.pass;},
	urlRoot : "webapi/client",
	defaults : {
		pass : " ",
		uname : " "
	},
	validate : function(attributes) {
		if (!attributes.uname || !attributes.pass) {
			alert("Enter Email Id & Password");
		}

	}

});

var loginCollection = Backbone.Collection.extend({
	// urlRoot: function(){return
	// "webapi/client+?uname="+this.uname+"+&+password="+this.pass;}
	model : login,
	url : "webapi/client"
});

var sch = Backbone.Model.extend({
	urlRoot : "webapi/searchREST",

	validate : function(attributes) {
		if (attributes.searchby == undefined || attributes.input == undefined) {
			return "Enter search criteria";
		}

	}
});

var searchObject = new sch();
var rev = Backbone.Model.extend({
	urlRoot : "webapi/booking"
});
var booking = new rev();
var searchRes = Backbone.Collection.extend({
	model : sch,
	url : "webapi/searchREST",
});

var searchCollect = new searchRes();
var receipt = Backbone.View.extend({
	initialize : function() {
		this.render();
	},
	render : function() {
		var temp = _.template($("#orderReceipt").html(), {});
		this.$el.html(temp(booking.toJSON()));
	},
	events : {
		"click #print" : function() {
			window.print();
		}
	}
});
var det = Backbone.View.extend({
	initialize : function() {
		this.render();
	},
	render : function() {
		var temp = _.template($("#detailView").html(), {});
		this.$el.html(temp(this.model.toJSON()));
	},
	events : {
		"click #res" : function(e) {
			e.preventDefault();
			var text = prompt("Number of copies to reserve", "");

			booking.fetch({
				data : {
					clientid : loginSet.get("clientID"),
					bookid : this.model.get("bookid"),
					num : text
				},
				success : function() {
					alert(booking.get("res"));
					if (booking.get("res") == "Booking Confirmed") {
						var showReceipt = new receipt({
							el : $("#test")

						});
					}
				}

			});

		}
	}

});

var confirmView = Backbone.View.extend({
	initialize : function() {
		this.render();
	},
	render : function() {
		var temp = _.template($("#ab").html(), {});
		this.$el.html(temp);
	},

});

var searchRes = Backbone.View.extend({

	initialize : function() {
		this.render();

	},
	render : function() {
		var self = this;
		searchCollect.each(function(sch) {

			var s = new sview({
				model : sch
			});
			self.$el.append(s.render().$el);
		});

	}
});

var sview = Backbone.View.extend({
	initialize : function() {

		this.render();

		// $(".searchres").mouseover(function(e){
		// $(this).css("background","cyan");
		// $(this).css("cursor","pointer");
		// });
		// $(".searchres").mouseleave(function(e){
		// $(this).css("background","white");
		// });

		$('.searchres').mouseover(function() {
			$(this).css("border", "1px solid #4c4");
			$(this).css("background", "#9f9");
			$(this).css("cursor", "pointer");
		});
		$('.searchres').mouseleave(function() {
			$(this).css("border", "1px dashed #ccc");
			$(this).css("background", "#eee");

		});
	},

	render : function() {
		var temp = _.template($("#searchV").html());

		this.$el.html(temp(this.model.toJSON()));
		console.log(this.model);
		return this;
	},
	events : {
		"click .searchres" : function(e) {
			e.preventDefault();

			var dview = new det({
				el : $("#test"),
				model : this.model
			});
		}

	}

});

var backView = Backbone.View.extend({
	initialize : function() {

		this.render();
		this.collection.on('request', function() {
			var lo = new loadingView({
				el : $("#test")
			});
		})

	},
	render : function() {
		var data = loginSet.toJSON();

		var temp = _.template($("#userkanaam").html());

		var html = temp(data)

		this.$el.html(html);
		return this;
	},
	events : {
		"submit #search" : function(e) {
			e.preventDefault();

			searchCollect.fetch({
				data : {
					searchby : $('input[name=s]:checked').val(),
					input : $('input[name=in]').val()
				},
				success : function() {

					if (searchCollect.length == 0) {
						alert("No Books Found");
					} else {
						var seView = new searchRes({
							el : $("#test")
						});
					}
					return true;

				},
				error : function() {
					alert("error");
				}

			});

		}
	}
});
var loginSet = new login();
var loadingView = Backbone.View.extend({
	initialize : function() {
		this.render();
	},
	render : function() {
		var temp = _.template($("#whileLoading").html(), {});
		this.$el.html(temp);
	},

});

var logView = Backbone.View.extend({
	initialize : function() {
		this.render()
	},
	render : function() {
		var temp = _.template($("#loginView").html(), {});
		this.$el.html(temp);
	},
	events : {
		"submit #login" : function(e) {

			e.preventDefault();

			loginSet.set({
				uname : $("#uname").val(),
				pass : $("#pass").val()
			});
			var lo = new loadingView({
				el : $("#test")
			});
			// console.log(loginCredentials.fetch());
			loginSet.fetch({
				data : {
					uname : loginSet.get("uname"),
					pass : loginSet.get("pass")
				},
				success : function() {
					if (loginSet.get("typeAcc") == "client") {
						var a = new backView({
							el : $("#test")
						});

						return true;
					} else if (loginSet.get("typeAcc") == "admin") {
						var a = new adminView({
							el : $("#test")
						});
					} else {
						alert("Wrong EmailID/Password");

						var l = new logView({
							el : $("#test")
						});

					}
				}
			});

		},
		"click #new" : function() {
			var abk = new newUserView({
				el : $("#test")
			});
		}
	}
});

$(document).ready(function(e) {

	var l = new logView({
		el : $("#test")
	});

	return false;

});
