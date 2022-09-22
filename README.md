# coverwhale-test-automation
<h2>Selenium test cases for Cover Whale repo</h2>

<b>Project Structure:</b>
<ol type="1">
<li>All the test case files are located under "src/test/java/testcases". You will find separate test case file for each module / functionality. (e.g. Login tests, Home page tests etc...)</li>
<li>DOM elements / WebElements should be defined under "src/main/java/pages" folder.</li>
<li>Configuration file "config.properties" in "src/main/java/config" folder contains all the configuration details like execution email details, admin user, password, environment execution URL etc... which are used in automation./</li>
<li>Utilities folder - "src/main/java/utilities" has code / files for Emailing the report (Emailer.java) and TestListner etc...</li>
<li>Execution reports and fail step screenshot are saved under "Reports" and "Reports/Screenshots" folder respectively.</li>
<li>"Test_Case_Steps.xslx" file available under "src/test/java" contains manual steps for the scenarios covered in automation suite/ respective test case file.</li>
</ol>

<b>Steps to Setup Project on your local:</b>
<ol type="1">
<li>Download and install Java SDK 8</li>
<li>Download and install Intellij Community edition from https://www.jetbrains.com/idea/download/</li>
<li>Download Apache Maven and extract zip file to specific folder.</li>
<li>Follow the steps to ensure all the system environment variables are setup correctly.</li>
https://www.tutorialspoint.com/maven/maven_environment_setup.htm
<li>Download and install Git</li>
<li>Clone the Git repository - {repo}to local folder.</li>
<li>Open command prompt and navigate to directory where project is cloned and run following command:</li>
a.	Mvn clean
<li>Wait till it completes the process and shows “Build Success” status.</li>
<li>Open the project in Intellij</li>
<li>Navigate to src\test\java\testcases\ and open any test case file.</li>

![image](https://user-images.githubusercontent.com/77983442/111899764-7fbe5c80-8a54-11eb-9ab8-7781873e57bf.png)

<li>You can run entire test suite / test case from Intellij. OR using maven command “mvn clean test” from command prompt.</li>
<li>After execution is complete, you should see the test execution report in Reports folder.</li>
<li>Open the TestReport.html in Chrome browser to see the result.</li>
![image](https://user-images.githubusercontent.com/77983442/111899801-af6d6480-8a54-11eb-9815-708a6cf7793f.png)
</ol>

<h2>Code Checkin Process:</h2>
<li>Take Git pull from master (this is to make sure you have latest code in your local) </li>
<li>Switch to local branch and merge code </li>
<li>Now Update your automation code to your local branch </li> 
<li>Move code to repo and create PR </li>
<li>Verify your PR does not have any conflicts before mergering PR to master </li> 
