# 【实现简单的语音识别功能】
#### 首先需要在百度开放云官网上创建应用，申请语音识别功能的权限
# 【注意点】
1.AndroidManifest.xml中需要添加权限
```
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
<uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
2.AndroidManifest.xml中添加申请信息
```
<meta-data
android:name="com.baidu.speech.APP_ID"
android:value="XXXXX" />
<!-- 请填写应用实际的API_KEY -->
<meta-data
android:name="com.baidu.speech.API_KEY"
android:value="XXXXX" />
<!-- 请填写应用实际的SECRET_KEY -->
<meta-data
android:name="com.baidu.speech.SECRET_KEY"
android:value="XXXXX" />
<service
android:name="com.baidu.speech.VoiceRecognitionService"
android:exported="false" />
```
3.注意jar包和so文件的导入
