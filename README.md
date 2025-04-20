# spr-sec-proto2
Spring-Security with Eclipse-Store: showcases issues with eclipseStore's clientGui / console


## Issue description
When securing the EclipseStore's clientGui with Spring-Security, the UI is unable to connect to the REST service:

![EclipseStoreClient Error](raw/img/eclipsestore-error.jpg?raw=true "EclipseStoreClient Error")


## Steps to reproduce
- open [http://localhost:8080/store-console](http://localhost:8080/store-console)
- enter credentials: user/password
- clientUi: select instance/connect: http://localhost:8080/store-data/default/
- see above error

Note that with disabled security everything works fine:

	SecurityConfig.java:
	.anyRequest().permitAll() )		//uncomment
	.anyRequest().authenticated() )		//comment


### Self backlink
[https://github.com/krabat/spr-sec-proto2](https://github.com/krabat/spr-sec-proto2)
