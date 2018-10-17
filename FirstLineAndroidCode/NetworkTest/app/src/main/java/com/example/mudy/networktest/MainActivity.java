package com.example.mudy.networktest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }

        Button button = (Button)findViewById(R.id.send_request);
        responseText = (TextView)findViewById(R.id.response_text);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId()==R.id.send_request){
            Log.d("NetWork", "onClick: ");
//            sendRequstWithHttpURLConnection();
            sendRequstWithOkHttp();
        }
    }

    private void sendRequstWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request requset = new Request.Builder()
                            .url("http://10.0.2.2/get_data.json")//这里10.0.2.2表示电脑本机127.0.0.1
                            .build();
                    Response response = client.newCall(requset).execute();
                    String responseData = response.body().string();
//                    Log.d("NetWork", responseData);
//                    showResponse(responseData);
//                    parseJSONWithJSONObject(responseData);
                    parseJSONWithGSON(responseData);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        }).start();
    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        Log.d("NetWork", "parseJSONWithGSON: "+jsonData);
        List<App> appList = gson.fromJson(jsonData,new TypeToken<List<App>>(){}.getType());
//        Type collectionType = new TypeToken<List<App>>(){}.getType();
//        List<App> appList = gson.fromJson(jsonData, collectionType);
        for (App app : appList){
            Log.d("NetWork", "id is "+app.getId());
            Log.d("NetWork", "name is "+app.getName());
            Log.d("NetWork", "version is "+app.getVersion());
        }
    }

    private void sendRequstWithHttpURLConnection(){
        //开始一个线程来发送网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://www.baidu.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    //对获取到的输入流进行读取
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    Log.d("NetWork", response.toString());
                    String line;
                    while ((line = reader.readLine())!=null){
                        response.append(line);
                    }
                    showResponse(response.toString());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if (reader != null){
                        try {
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }


        }).start();
    }

    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });
    }
    private void parseJSONWithJSONObject(String jsonData) {
        try{
            Log.d("NetWork", "parseJSONWithJSONObject: "+jsonData);
            JSONArray jsonArray = new JSONArray(jsonData);
            for (int i = 0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");
                Log.d("NetWork", "id is "+id);
                Log.d("NetWork", "name is "+name);
                Log.d("NetWork", "version is "+version);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
