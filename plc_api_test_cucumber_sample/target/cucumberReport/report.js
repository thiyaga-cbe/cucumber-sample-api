$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("getclientid.feature");
formatter.feature({
  "line": 1,
  "name": "To get the client id",
  "description": "",
  "id": "to-get-the-client-id",
  "keyword": "Feature"
});
formatter.scenario({
  "comments": [
    {
      "line": 3,
      "value": "#Getting the Cliend ID"
    }
  ],
  "line": 4,
  "name": "To get the client id",
  "description": "",
  "id": "to-get-the-client-id;to-get-the-client-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "the API are up and running",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "a user perform the get request",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "the response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I see the json response includes in any order",
  "rows": [
    {
      "cells": [
        "clientID",
        "1"
      ],
      "line": 9
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "plcApi.the_API_are_up_and_running()"
});
formatter.result({
  "duration": 1172696078,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.a_user_perform_the_get_request()"
});
formatter.result({
  "duration": 3171646900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "plcApi.the_response_code_should_be(int)"
});
formatter.result({
  "duration": 94951671,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.i_see_the_json_response_includes_in_any_order(String,Object\u003e)"
});
formatter.result({
  "duration": 732552963,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 11,
      "value": "#Generate the Session for the user by sending the Client ID and Security Token in the Header (Session ID in Encrypted)"
    }
  ],
  "line": 12,
  "name": "Generate session for user",
  "description": "",
  "id": "to-get-the-client-id;generate-session-for-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "the Generate Session for user API",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "a user perform the post request with user",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "I see the json response for Generate session for user",
  "rows": [
    {
      "cells": [
        "responseCode",
        "1"
      ],
      "line": 17
    },
    {
      "cells": [
        "responseDescription",
        "Success"
      ],
      "line": 18
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "plcApi.the_Generate_Session_for_user_API()"
});
formatter.result({
  "duration": 2881816,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.a_user_perform_the_post_request_with_user()"
});
formatter.result({
  "duration": 957344487,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "plcApi.the_response_code_should_be(int)"
});
formatter.result({
  "duration": 3291223,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.i_see_the_json_response_for_Generate_session_for_user(String,Object\u003e)"
});
formatter.result({
  "duration": 28610604,
  "error_message": "java.lang.NullPointerException\r\n\tat plc_api_test.plcApi.i_see_the_json_response_for_Generate_session_for_user(plcApi.java:111)\r\n\tat ✽.And I see the json response for Generate session for user(getclientid.feature:16)\r\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 20,
      "value": "#Check the session for the user by passing Session ID in the parameter"
    }
  ],
  "line": 21,
  "name": "Check the session for user",
  "description": "",
  "id": "to-get-the-client-id;check-the-session-for-user",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "check the session for user",
  "keyword": "Given "
});
formatter.step({
  "line": 23,
  "name": "a user perform to get the check session for user",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "the response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 25,
  "name": "I see the json response for check the session for user",
  "rows": [
    {
      "cells": [
        "responseCode",
        "1"
      ],
      "line": 26
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "plcApi.check_the_session_for_user()"
});
formatter.result({
  "duration": 114041,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.a_user_perform_to_get_the_check_session_for_user()"
});
formatter.result({
  "duration": 785022464,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "plcApi.the_response_code_should_be(int)"
});
formatter.result({
  "duration": 2429453,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.i_see_the_json_response_for_check_the_session_for_user(String,Object\u003e)"
});
formatter.result({
  "duration": 14062394,
  "error_message": "java.lang.NullPointerException\r\n\tat plc_api_test.plcApi.i_see_the_json_response_for_check_the_session_for_user(plcApi.java:160)\r\n\tat ✽.And I see the json response for check the session for user(getclientid.feature:25)\r\n",
  "status": "failed"
});
formatter.scenario({
  "comments": [
    {
      "line": 28,
      "value": "#Checking the Client ID by passing Client ID and Security Token, output will be Boolean"
    }
  ],
  "line": 29,
  "name": "Check the Client ID",
  "description": "",
  "id": "to-get-the-client-id;check-the-client-id",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 30,
  "name": "a user perform to check the cilent ID",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "the response code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "I see the json response as true",
  "keyword": "And "
});
formatter.match({
  "location": "plcApi.a_user_perform_to_check_the_cilent_ID()"
});
formatter.result({
  "duration": 960444122,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 28
    }
  ],
  "location": "plcApi.the_response_code_should_be(int)"
});
formatter.result({
  "duration": 4320253,
  "status": "passed"
});
formatter.match({
  "location": "plcApi.i_see_the_json_response_as_true()"
});
formatter.result({
  "duration": 1052218,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 34,
      "value": "#Expiring the Session ID by passing the Client ID, Security ID and Session ID after decrypting"
    }
  ],
  "line": 35,
  "name": "Expire Session",
  "description": "",
  "id": "to-get-the-client-id;expire-session",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 36,
  "name": "a user perform to post expire the session",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "I see the json response for expire the session",
  "rows": [
    {
      "cells": [
        "responseCode",
        "1"
      ],
      "line": 38
    },
    {
      "cells": [
        "responseDescription",
        "Success"
      ],
      "line": 39
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "plcApi.a_user_perform_to_post_expire_the_session()"
});
formatter.result({
  "duration": 18994288,
  "error_message": "java.lang.IllegalArgumentException: Header value cannot be null\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown Source)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.invoke(CachedConstructor.java:80)\r\n\tat org.codehaus.groovy.reflection.CachedConstructor.doConstructorInvoke(CachedConstructor.java:74)\r\n\tat org.codehaus.groovy.runtime.callsite.ConstructorSite$ConstructorSiteNoUnwrap.callConstructor(ConstructorSite.java:84)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallConstructor(CallSiteArray.java:60)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:235)\r\n\tat org.codehaus.groovy.runtime.callsite.AbstractCallSite.callConstructor(AbstractCallSite.java:247)\r\n\tat io.restassured.internal.assertion.AssertParameter.notNull(AssertParameter.groovy:26)\r\n\tat io.restassured.internal.assertion.AssertParameter$notNull.callStatic(Unknown Source)\r\n\tat org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCallStatic(CallSiteArray.java:56)\r\n\tat io.restassured.internal.assertion.AssertParameter$notNull.callStatic(Unknown Source)\r\n\tat io.restassured.internal.RequestSpecificationImpl.header(RequestSpecificationImpl.groovy:873)\r\n\tat plc_api_test.plcApi.a_user_perform_to_post_expire_the_session(plcApi.java:188)\r\n\tat ✽.When a user perform to post expire the session(getclientid.feature:36)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "plcApi.i_see_the_json_response_for_expire_the_session(String,Object\u003e)"
});
formatter.result({
  "status": "skipped"
});
});