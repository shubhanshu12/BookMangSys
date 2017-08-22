package org.book.res.bookRest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.book.res.bookRest.Org;
import org.book.res.bookRest.admin;
import org.book.res.bookRest.config;
import org.book.res.bookRest.dto.IssueLateDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;

@Path("/editlatefeeissueperiod")
public class LateFeeIssuePeriodREST {
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public IssueLateDTO getissuelate(@PathParam("id") int adminid) {
		config co = new config();
		Session session = co.getSession();
		Transaction tx = co.getTx();
		admin AdminObj = new admin();
		AdminObj = (admin) session.get(admin.class, adminid);
		int latefee = AdminObj.getOrg().getLatefee();
		int issue = AdminObj.getOrg().getIssueperiod();
		int orgid = AdminObj.getOrg().getOrgid();
		IssueLateDTO issuelate = new IssueLateDTO();
		issuelate.setIssue(issue);
		issuelate.setLatefee(latefee);
		issuelate.setOrgid(orgid);
		return issuelate;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String setissue(IssueLateDTO setnewissuelate) {
		config co = new config();
		Session session = co.getSession();
		Transaction tx = co.getTx();
		JSONObject obj = new JSONObject();
		Org org = new Org();
		org = (Org) session.get(Org.class, setnewissuelate.getOrgid());
		org.setIssueperiod(setnewissuelate.getIssue());
		org.setLatefee(setnewissuelate.getLatefee());
		try {
			tx = session.beginTransaction();
			session.save(org);
			tx.commit();
			obj.put("res", "Late Fee/ Issue Period Updated Successfully");
		} catch (Exception e) {
			obj.put("res", "There is some error");
		}
		return obj.toString();
	}
}
