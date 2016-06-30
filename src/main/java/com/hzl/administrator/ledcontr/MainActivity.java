package com.hzl.administrator.ledcontr;

import android.util.Log;
import android.widget.TextView;

import com.hzl.administrator.BaseActivity.SettingManager;
import com.xtremeprog.xpgconnect.GWifiSDK;
import com.xtremeprog.xpgconnect.XPGWifiDevice;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity{

    JSONObject st;
    @butterknife.Bind(R.id.textView_size)
    TextView mTextViewSize;
    private List<ControlDevice> devicelist;
    protected SettingManager setmanager;


   Thread thread=new Thread(){
       @Override
       public void run() {
           super.run();
           try {
               st=sendJson("LED_B", 125);
           } catch (JSONException e) {
               e.printStackTrace();
           }
           GWifiSDK.PrintBiz("l_control_req", (String) null, "LAN device control: mac = " + "18FE34D3CD94" + ", data = " + st);
       }
   };
    private synchronized void bind_device() {
        EmptyData();
        for (int i = 0; i < BaseActivity.deviceslist.size(); i++) {
            XPGWifiDevice device = BaseActivity.deviceslist.get(i);
            ControlDevice controlDevice = new ControlDevice(device, true);
            devicelist.add(controlDevice);
            mTextViewSize.setText(BaseActivity.deviceslist.size());
            Log.d("sssss", String.valueOf(BaseActivity.deviceslist.size()) + "sssss");
        }
    }

    private JSONObject sendJson(String key, Object value) throws JSONException {
        final JSONObject jsonsend = new JSONObject();
        JSONObject jsonparam = new JSONObject();
        jsonsend.put("cmd", 1);
        jsonparam.put(key, value);
        jsonsend.put("entity0", jsonparam);
        return jsonsend;
    }
    private void EmptyData() {
        devicelist = new ArrayList<ControlDevice>();
    }
}
