package com.example.day010;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.day010.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        viewDataBinding.loadWeb.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                viewDataBinding.bar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                viewDataBinding.bar.setVisibility(View.GONE);
            }
        });
        viewDataBinding.loadWeb.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                viewDataBinding.bar.setProgress(newProgress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                result.cancel();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        WebSettings settings = viewDataBinding.loadWeb.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        viewDataBinding.loadWeb.loadUrl("file:///android_asset/h5.html");
        viewDataBinding.loadWeb.addJavascriptInterface(this,"home");

    }
    @JavascriptInterface
    public void show(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    @JavascriptInterface
    public void showNull(){
        Toast.makeText(this, "张三Null", Toast.LENGTH_SHORT).show();
    }



    public void send(View view) {
        String url = viewDataBinding.url.getText().toString();
        viewDataBinding.loadWeb.loadUrl(url);
    }

    public void go(View view) {
        if(viewDataBinding.loadWeb.canGoForward()){
            viewDataBinding.loadWeb.goForward();
        }
    }

    public void back(View view) {
        if(viewDataBinding.loadWeb.canGoBack()){
            viewDataBinding.loadWeb.goBack();
        }
    }

    public void refresh(View view) {
        viewDataBinding.loadWeb.reload();
    }

    public void jsAlert(View view) {
//        viewDataBinding.loadWeb.loadUrl("javascript:callJs()");
        viewDataBinding.loadWeb.evaluateJavascript("javascript:callJs()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void jsAlert2(View view) {
        viewDataBinding.loadWeb.loadUrl("javascript:callJs1('"+"刘继权"+"')");
    }
}