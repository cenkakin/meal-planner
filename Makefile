ACTIVE_SPRING_PROFILE = dev

generate-jooq:
	./gradlew generateJooq

start-spring:
	./gradlew bootRun --args='--spring.profiles.active=$(ACTIVE_SPRING_PROFILE)'

start-db:
	docker-compose up