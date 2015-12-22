package de.dailab.plistacontest.client;


import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.Spark.post;
import static spark.SparkBase.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {

	private static HttpService service = new HttpService();

	public static void main(String[] args) {

		port(Integer.valueOf(System.getenv("PORT")));
		staticFileLocation("/public");

		post("/", (request, response) -> service.servePost(request, response));

		get("/", (request, response) -> service.serveGet(request, response));

		get("/", (request, response) -> {
			Map<String, Object> attributes = new HashMap<>();
			attributes.put("message", "Hello World!");

			return new ModelAndView(attributes, "index.ftl");
		}, new FreeMarkerEngine());

	}

	private static Object servePost(Request request, Response response) {
		// TODO Auto-generated method stub
		return null;
	}

}
