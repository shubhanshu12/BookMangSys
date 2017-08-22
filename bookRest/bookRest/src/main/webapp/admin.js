var CreateEntry = Backbone.Model.extend({
	urlRoot : "webapi/create"
});
var nt = new CreateEntry();

var ViewDet = Backbone.Model.extend({});

var ViewCollection = Backbone.Collection.extend({
	url : "webapi/viewing",
	model : ViewDet
});
var ViewCollect = new ViewCollection();
var createV = Backbone.View.extend({
	initialize : function() {
		this.render();

	},
	render : function() {

		var temp = _.template($("#entry").html(), {});
		this.$el.html(temp(loginSet.toJSON()));

	},
	events : {
		"submit #formEntry" : function() {
			nt.set({
				title : $("#title").val(),
				author : $("#author").val(),
				publisher : $("#pub").val(),
				publicationDate : $("#pubdate").val(),
				isbn : $("#isbn").val(),
				totalBooks : $("#total").val(),
				booksAvailable : $("#ava").val(),
				subject : $("#subject").val(),
				edition : $("#edition").val(),
				subject : $("#sub").val()
			});

			if (nt.save()) {
				alert("Book added successfully");
			} else {
				alert("Error");
			}
		}
	}

});
var viewing = Backbone.View.extend({
	initialize : function() {
		this.render();

	},
	render : function() {
		var self = this;
		ViewCollect.each(function(ViewDet) {
			if (ViewDet.get("statusOfBooking") == "Booking Confirmed") {
				var s = new eachview({
					model : ViewDet
				});

			} else {
				var s = new EachViewWithoutButton({
					model : ViewDet
				});

			}
			self.$el.append(s.render().$el);
		});

	}

});

var viewingIssued = Backbone.View.extend({
	initialize : function() {
		this.render();

	},
	render : function() {
		var self = this;
		ViewCollect.each(function(ViewDet) {

			var b = new EachViewWithoutButton({
				model : ViewDet
			});
			self.$el.append(b.render().$el);

		});

	}

});
var issue = Backbone.Model.extend({
	url : "webapi/viewing",

});
var iss = new issue();
var eachview = Backbone.View.extend({
	initialize : function() {
		this.render();

	},

	render : function() {
		var temp = _.template($("#OrderVi").html());
		this.$el.html(temp(this.model.toJSON()));
		console.log(this.model);
		return this;
	},
	events : {
		"click #a" : function() {

			if (iss.save({}, {
				url : "webapi/viewing?orderid=" + this.model.get("orderID")
						+ "&adminid=" + loginSet.get("clientID")
			})) {
				alert("Status set to Issued");
			} else {
				alert("Something went wrong.");
			}

		}
	}
});

var BookReturn = Backbone.View.extend({
	initialize : function() {
		this.render();

	},

	render : function() {
		console.log(this.model.toJSON());
		var temp = _.template($("#BillReceipt").html(), {});
		this.$el.html(temp(this.model.toJSON()));

	},
	events : {
		"click #print" : function() {
			window.print();
		},

	}
});

var LateFee = Backbone.Model.extend({
	urlRoot : "webapi/latefee"
});
var latefeefetch = new LateFee();
var CombineClientLatefee = Backbone.Model.extend();
var CloseBooking = Backbone.Model.extend({
	urlRoot : "webapi/close"
});
var CloseBookingObj = new CloseBooking();
var EachViewWithoutButton = Backbone.View.extend({
	initialize : function() {
		this.render();

	},

	render : function() {
		var temp = _.template($("#OrderViewIssued").html());
		this.$el.html(temp(this.model.toJSON()));

		return this;
	},
	events : {
		"click #return" : function() {

			var self = this;
			console.log(this.model);
			CloseBookingObj.fetch({
				data:{orderid: this.model.get("orderID")},
			
				success : function() {
					if (CloseBookingObj.get("res") == "Closed") {
						alert("Booking Closed");
						latefeefetch.fetch({
							data : {
								adminid : self.model.get("client.clientID"),
								orderid : self.model.get("orderID")
							},
							success : function() {
								var Combined = new CombineClientLatefee();
								Combined.set({
									details : self.model,
									late : latefeefetch
								});
								var bill = new BookReturn({
									el : $("#test"),
									model : Combined
								});

							}
						});

					} else {
						alert("Something went wrong.");
					}
				}
		});

		},

	}
});

var OrderView = Backbone.View.extend({

	initialize : function() {
		this.render();
		$(".ViewButtons").mouseover(function() {
			$(this).css("cursor", "pointer");
		});

	},
	render : function() {
		var temp = _.template($("#viewing").html(), {});
		this.$el.html(temp(loginSet.toJSON()));
	},
	events : {
		"click #all" : function() {
			ViewCollect.fetch({
				data : {
					view : "all"
				},
				success : function() {
					var ew = new viewing({
						el : $("#test")
					});
					return true;
				}
			});
		},
		"click #issued" : function() {
			ViewCollect.fetch({
				data : {
					view : "issued"
				},
				success : function() {
					var ew = new viewingIssued({
						el : $("#test")
					});
					return true;
				}
			});
		},
		"click #pending" : function() {
			ViewCollect.fetch({
				data : {
					view : "pending"
				},
				success : function() {
					var ew = new viewing({
						el : $("#test")
					});
					return true;
				}
			});
		},
		"click #defaulters" : function() {
			ViewCollect.fetch({
				data : {
					view : "defaulters"
				},
				success : function() {
					var ew = new viewingIssued({
						el : $("#test")
					});
					return true;
				}
			});
		},

		"submit #searchOrder" : function(e) {
			e.preventDefault();
			ViewCollect.fetch({
				data : {
					view : "orderID",
					orderID : $("#orderid").val()
				},
				success : function() {
					var ew = new viewing({
						el : $("#test")
					});
					return true;
				}

			});
		}

	}
});
var bookfetch = Backbone.Model.extend({
	urlRoot : "webapi/searchREST",
});
var bookfetchcollect = Backbone.Collection.extend({
	model : bookfetch,
	url : "webapi/searchREST",
});
var bookCollect = new bookfetchcollect();
var AdminEditView = Backbone.View.extend({

	initialize : function() {
		this.render();
	},
	render : function() {
		var temp = _.template($("#EditViewSearchAdmin").html());
		this.$el.html(temp(loginSet.toJSON()));
		return this;
	},
	events : {
		"submit #searchAdmin" : function(e) {

			e.preventDefault();

			bookCollect.fetch({
				data : {
					searchby : $('input[name=s]:checked').val(),
					input : $('input[name=in]').val()
				},
				success : function() {
					if (bookCollect.length == 0) {
						alert("No Books Found");
					} else {
						var seView = new AdminSearchResEdit({
							el : $("#test")
						});
					}
					return true;

				}
			});

		}
	}

});

var AdminSearchResEdit = Backbone.View.extend({

	initialize : function() {
		this.render();

	},
	render : function() {
		var self = this;
		bookCollect.each(function(bookfetch) {

			var sx = new ResultView({
				model : bookfetch
			});
			self.$el.append(sx.render().$el);
		});

	}
});

var ResultView = Backbone.View.extend({
	initialize : function() {

		this.render();

		$('.AdminSearchResEditView').mouseover(function() {
			$(this).css("border", "1px solid #4c4");
			$(this).css("background", "#9f9");
			$(this).css("cursor", "pointer");
		});
		$('.AdminSearchResEditView').mouseleave(function() {
			$(this).css("border", "1px dashed #ccc");
			$(this).css("background", "#eee");

		});
	},

	render : function() {
		var temp = _.template($("#AdminSearchEditBook").html());

		this.$el.html(temp(this.model.toJSON()));
		console.log(this.model);
		return this;
	},
	events : {
		"click #edit" : function(e) {
			e.preventDefault();

			var edit = new EditingView({
				el : $("#test"),
				model : this.model
			});
		},
		"click #delete" : function(e) {
			e.preventDefault();

			var edit = new DeleteView({
				el : $("#test"),
				model : this.model
			});
		},
	}

});
var deletebook=Backbone.Model.extend({
	urlRoot:"webapi/delete"
});
var deletebookobj=new deletebook();
var DeleteView=Backbone.View.extend({
	initialize:function(){
		this.render();
	},
	render:function(){
		var temp = _.template($("#DeleteViewDetailed").html());
		this.$el.html(temp(this.model.toJSON()));
	},
	events:{
		"click #del":function(){
			deletebookobj.set({id:this.model.get("bookid")});
			deletebookobj.destroy({
				success:function(){
					alert(deletebookobj.get("res"));
				}
			});
		}
	}
});



var editbookentry = Backbone.Model.extend({
	urlRoot : "webapi/edit"
});
var seteditvalue = new editbookentry();
var EditingView = Backbone.View.extend({

	initialize : function() {
		this.render();

	},
	render : function() {
		var temp = _.template($("#EditViewDetailed").html());
		this.$el.html(temp(this.model.toJSON()));
	},
	events : {
		"submit #BookEdit" : function() {

			console.log(this.model.toJSON());
			seteditvalue.set({
				bookid : this.model.get("bookid"),
				title : $("#title").val(),
				author : $("#author").val(),
				publisher : $("#pub").val(),
				publicationDate : $("#pubdate").val(),
				subject : $("#sub").val(),
				edition : $("#ed").val(),
				isbn : $("#isbn").val(),
				issn : $("#issn").val(),
				totalBooks : $("#totalbooks").val(),
			});
			if (seteditvalue.save()) {
				alert("Book Record Updated");
			} else {
				alert("Something Went Wrong");
			}
			return false;
		}
	}
});
var getissue=Backbone.Model.extend({
	urlRoot:"webapi/editlatefeeissueperiod"
});
var setlateissue=new getissue();
var editlatefeeissueperiod=Backbone.View.extend({
	initialize: function(){
		this.render();
	},
	render:function(){
		var temp = _.template($("#issuePeriodlatefeeView").html(), {});
		this.$el.html(temp(this.model.toJSON()));
	},
	events:{
		"submit #setlateissue":function(e){
			e.preventDefault();
			setlateissue.set({
				
					latefee: $("#lateFee").val(),
					issue:$("#issue").val(),
					orgid:this.model.get("orgid")
				
			});
			setlateissue.save({
				success:function(){
					alert("Updated");
				}
			});
		}
	}
});

var getissueobj= new getissue();
var adminView = Backbone.View.extend({
	initialize : function() {
		this.render();
		$(".m").mouseover(function() {
			$(this).css("border", "1px solid #4c4");
			$(this).css("background", "#9f9");
			$(this).css("cursor", "pointer");
		});
		$('.m').mouseleave(function() {
			$(this).css("border", "1px dashed #ccc");
			$(this).css("background", "#eee");

		});
	},
	render : function() {
		var temp = _.template($("#admin").html(), {});
		this.$el.html(temp(loginSet.toJSON()));
	},

	events : {
		"click #cre" : function() {
			var m = new createV({
				el : $("#test")
			});
		},
		"click #ViewOrder" : function() {
			var k = new OrderView({
				el : $("#test")
			});
		},
		"click #edit" : function() {

			var q = new AdminEditView({
				el : $("#test")
			});
		},
		"click #issueperiodlatefee" : function() {
			getissueobj.set({id:loginSet.get("clientID")});
			getissueobj.fetch({
				success:function(){
					var q = new editlatefeeissueperiod({
						el : $("#test"),
						model: getissueobj
					});
				}
			});
			
		}

	}

});
