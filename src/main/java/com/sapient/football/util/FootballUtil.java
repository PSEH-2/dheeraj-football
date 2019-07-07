package com.sapient.football.util;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapient.football.controller.FootballController;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Common utility class having method to call External API's
 * 
 * @author beta
 *
 */
public class FootballUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FootballUtil.class);

	public static String callExternalAPI(Map<String, String> queryParameters) throws IOException {

		OkHttpClient client = new OkHttpClient().newBuilder().followRedirects(false).build();
		HttpUrl.Builder urlBuilder = HttpUrl.parse(FootBallConstants.EXTERNAL_URL).newBuilder();
		for (Map.Entry<String, String> entry : queryParameters.entrySet())
			urlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
		String url = urlBuilder.build().toString();
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		ResponseBody responseBody = response.body();
		String responseBodyString = responseBody.string();
		responseBody.close();
		response.close();
		LOGGER.info("response body String " + responseBodyString);
		return responseBodyString;
	}

}
