# android_examples



# Unit Testing

###### TestCase 
– Plain old JUnit test case. It can be extended to test utility classes that are not tied to the Android framework.

###### AndroidTestCase
– It extends JUnit’s TestCase. It’s a lighter testing class compared to ActivityTestCase. It doesn’t need to launch an activity to run it. Its getContext() method allows you to get an injected context if you need one. Since you can get a context from this class, you can inflate your UI objects to test their behaviors.

###### ActivityInstrumentationTestCase2 
– It’s the newer version of ActivityInstrumentationTestCase. ActivityInstrumentationTestCase is deprecated in Android SDK 1.5. It’s a heavier testing class compared to AndroidTestCase. It provides UI and functional testing for a single activity. You can get an injected activity that you are testing on by calling its getActivity() method. The activity being tested is launched and finished before and after each test.

###### ActivityUnitTestCase 
– It gives the tested activity an isolated environment. When using it to test an activity, the activity is not attached to the system. This gives you more control over what kind of environment that you want your activity to be tested in.
ApplicationTestCase – It provides testing for Application classes. It can be used to test the life cycle of an application.

###### InstrumentationTestRunner
– The runner that runs the Android test cases.
