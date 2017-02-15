# SpringReadPropertyFile
How to read properties from property file in Spring (using annotations)

A simple program to read properties from property file in two ways using annotations.

1) Through @Value annotation using @PropertySource

2) Through "Environment" object.


<b>*Important*</b> : <br/>
We need to instatiate the object using @Autowired annotation instead of creating in regular way using "new ....()"

Example:

I am accessing the properties in "EmailServiceImpl". Hence, I autowired this class in "EmailConroller" where i invoke the service.
Please refer to the comments in the code.


Thanks, <br/>
Subhani
