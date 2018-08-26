build:
	docker build -t atmcarmo/jenkins .

run:
	docker run -d -v /var/run/docker.sock:/var/run/docker.sock -v $$(which docker):/usr/bin/docker -p 8080:8080 --name atmcarmo-jenkins atmcarmo/jenkins

stop:
	docker stop atmcarmo-jenkins

rm:
	docker rm atmcarmo-jenkins

stop-rm:
	docker rm $$(docker stop atmcarmo-jenkins)

shell:
	docker exec -it atmcarmo-jenkins /bin/bash
