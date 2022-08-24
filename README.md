# Process Pension Micro Service

To run this service in your local, clone the repository and open any IDE like `Eclipse,VS Code,IntelliJ,etc..` and run `mvn clean install` in the terminal and after successful completion run the application as `Spring Boot App`.

This service provides the feasibility to calculate the Pension Amount and Bank Service Charges.

## Resources

You need to have Postman, lombook.jar installed

To make a health check on this service, hit @GET `http://localhost:8300/process/manage/health`

This service requires an Aadhar number and Authorization header as initial inputs.

To access the service, hit @POST `http://localhost:8300/process/api/v1/ProcessPension` and include the Authorization Header as below

`Authorization :- Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY2MTMzNzk3MCwiaWF0IjoxNjYxMzM2MTcwfQ.sWL6aHruCUHUwWollCxiGXtMYcDogsL3AifI13pum4AqW3w0_vCcy7CsxZvP9jeQWRF4j8__DSSe6i3SidVXug`

Also, pass valid Aadhaar number as below in the body section in a JSON format

    {
        "aadharNumber": "398501170207"
    }

Then the service makes internal call to Pension Detail Micro Service with the aadhaar number to fetch the details of pensioner

Once the details are fetched, it then calculates the Pension amount and Bank service charges and returns as a final response.

The final response is as below for a private bank

    {
        "pensionAmount": 16500.0,
        "bankServiceCharge": 550.0
    }

The post processed details of the pensioner are stored in an `H2` in memory data base which can be accessed at [H2 Console](http://localhost:8300/process/h2).

To see details, open the above link and enter the following details

1. JDBC URL : `jdbc:h2:mem:testdb`
2. User Name : `sa`

and hit connect. An UI of H2 Console is displayed

Now run the following query in the statements and hit `Run`

`SELECT * FROM PENSION_DETAILS_ENTITY;`

The available details are displayed.

Kudos, you just accessed the Process Pension Details with an Aadhaar number.

The Front end for this service is as below

1)[Pension Management Portal](https://github.com/PrakashYashwanth/pension-management-portal)
