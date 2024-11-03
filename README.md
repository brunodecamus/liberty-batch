# liberty-batch

Lister tous les jobinstances
https://localhost:9443/ibm/api/batch/jobinstances/

/ibm/api/batch/v4/jobinstances
/ibm/api/batch/v4/jobinstances/{jobinstanceid}
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/jobexecnum/{jobexecutionnumber}
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/jobexecnum/{jobexecutionnumber}/stepexecutions/{stepname}
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/jobexecutions
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/jobexecutions/{jobexecutionid}/joblogs
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/jobexecutions/{jobexecutionnumber}
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/jobexecutions/{jobexecutionnumber}/stepexecutions/{stepname}
/ibm/api/batch/v4/jobinstances/{jobinstanceid}/joblogs

/ibm/api/batch/v4/jobexecutions
/ibm/api/batch/v4/jobexecutions/{jobexecutionid}
/ibm/api/batch/v4/jobexecutions/{jobexecutionid}/jobinstance
/ibm/api/batch/v4/jobexecutions/{jobexecutionid}/joblogs
/ibm/api/batch/v4/jobexecutions/{jobexecutionid}/stepexecutions
/ibm/api/batch/v4/jobexecutions/{jobexecutionid}/stepexecutions/{stepname}

/ibm/api/batch/v4/stepexecutions/{stepexecutionid}


POST https://localhost:9443/ibm/api/batch/jobinstances
{
    "applicationName": "liberty-batch-ear",
    "moduleName": "liberty-batch-ejb.jar",
    "componentName": "MyScheduler",
    "jobXMLName": "jobTest.xml",
    "jobParameters": {
        "propertyBatchlet1": "propertyBatchlet1____________________",
        "paramA": "jjjj____________"
    }
}
