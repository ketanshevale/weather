////Develop a REST endpoint that accepts the weather reading from the mock weather sensor [http://mocker.egen.io] and stores into your app datastore.
--------------------------------------------------------------------------------------------------
////Develop another set of REST endpoints that can do the following:
//Get the list of cities that have ever reported their weather in the past.
//Get the latest weather for a given city.
//Get the latest weather property for a given city, e.g get the latest temperature for Chicago, get the latest humidity for Miami.
//Get hourly averaged weather for a given city.
//Get daily averaged weather for a given city.
--------------------------------------------------------------------------------------------------
Launch one AWS instance configured with Java, nginx, tomcat, jenkins etc. installed
Deploy the war file on tomcat server on AWS instance.
Configure Jenkins to run a build job after every commit on your repo and deploy to tomcat server on AWS instance.
--------------------------------------------------------------------------------------------------
Develop a SpringBoot version of the same REST API.
Containerize this SpringBoot microservice using Docker.
Deploy the docker container on AWS instance.
Configure Jenkins to run a build job after every commit on your repo and deploy to AWS instance.

--------------------------------------------------------------------------------------------------

FORMAT Must	be	one	of	the	following:
feat: A	new	feature
fix: A	bug	fix
docs: Documentation	only	changes
style: Changes	that	do	not	affect	the	meaning	of	the	code	(white-space,	formatting,	
missing	semi-colons,	etc.)
refactor: A	code	change	that	neither fixes	a	bug	nor	adds	a	feature
perf: A	code	change	that	improves	performance
test: Adding	missing	tests
chore: Changes	to	the	build	process	or	auxiliary	tools	and	libraries	such	as	
documentation	generation.
The	subject	contains	succinct	description	of	the	change:
1. use	the	imperative,	present	tense:	"change"	not	"changed"	nor	"changes"
2. don't	capitalize	first	letter
3. no	dot	(.)	at	the	end
EXAMPLES
feat(module-client):	add	bootstrap	to	the	styling
feat(module-api):	init	api	module
feat(module-api):	implement	user	authentication
test(module-client):	add	jasmine/karma	config
style(module-client):	format	JavaScript	code
refactor(module-client):	use	directory	structure	specified	by	John	Papa
docs(module-client):	update	readme	with	how	to	run