/*
 * Name: AddDevice.java
 * Project: SensorAct, MUC@IIIT-Delhi 
 * Version: 1.0
 * Date: 2012-05-10
 * Author: Nipun Batra
 */
package edu.iiitd.muc.sensoract.apis;

/*
 * Standard play imports
 */
import play.libs.WS.HttpResponse;
import edu.iiitd.muc.sensoract.constants.Const;
import edu.iiitd.muc.sensoract.utilities.SecretKey;
import edu.iiitd.muc.sensoract.utilities.SendHTTPRequest;

public class GenerateSecretKey extends SensorActAPI {
	/**
	 * Services the adddevice API.
	 * <p>
	 * Followings are the steps to be followed to add a new device profile
	 * successfully to the repository.
	 * <ol>
	 * <li>Gets the JSON string containing device profile from UI
	 * <li>Since the validation had been performed at the UI,this request is
	 * just tunneled to the repository
	 * <li>Replaces the secret key with the actual secret key
	 * <li>If the addition of the device was successful,the succesful Response
	 * format is sent to the UI which interprets the same and reloads the page
	 * <li>If the addition of the device is unsuccessful,corresponding error
	 * message is sent to the UI
	 * </ol>
	 * <p>
	 * 
	 * @param body
	 *            User credentials
	 */
	public final void doProcess(String body) {
		String secretkey = new SecretKey().getSecretKeyFromHashMap(session
				.get(Const.USERNAME));
		String generateRequestWithSecretKey = body.replace(
				Const.FAKE_SECRET_KEY, secretkey);
		logger.info(Const.API_GENERATESECRETKEY, secretkey + " "
				+ generateRequestWithSecretKey);

		HttpResponse responseFromBroker = new SendHTTPRequest()
				.sendPostRequest(Const.URL_REPOSITORY_GENERATE_SECRET_KEY,
						Const.MIME_TYPE_JSON, Const.API_GENERATESECRETKEY,
						generateRequestWithSecretKey);
		renderJSON(responseFromBroker.getString());
	}

}
