package edu.iiitd.muc.sensoract.apis;

import com.google.gson.Gson;

import controllers.Application;

public class SensorActAPI extends Application {

	public static ParamValidator validator = new ParamValidator();
	public static Gson gson = new Gson();
	public static RegisterUser registeruser = new RegisterUser();
	public static ListAllDevices listAllDevices = new ListAllDevices();
	public static ListAllDeviceTemplates listAllDeviceTemplates = new ListAllDeviceTemplates();

	public static AddDevice addDevice = new AddDevice();
	public static AddDeviceTemplate addDeviceTemplate = new AddDeviceTemplate();

	public static DeleteDevice deleteDevice = new DeleteDevice();
	public static DeleteDeviceTemplate deleteDeviceTemplate = new DeleteDeviceTemplate();

	public static QueryData queryData = new QueryData();
	public static Login login = new Login();
	public static GetRepositoryInfo getRepositoryInfo = new GetRepositoryInfo();
	public static GenerateSecretKey generateSecretKey = new GenerateSecretKey();
	public static FindDevice findDevice = new FindDevice();
	public static FindDeviceTemplate findDeviceTemplate = new FindDeviceTemplate();

}
