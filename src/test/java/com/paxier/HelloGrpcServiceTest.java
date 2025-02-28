package com.paxier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

@QuarkusTest
class HelloGrpcServiceTest {
    @GrpcClient
    HelloWorldService helloWorldService;

    @Test
    void testHello() {
        HelloWorldResponse reply = helloWorldService.helloWorld(HelloWorldRequest.newBuilder().setName("Neo").build()).await().atMost(Duration.ofSeconds(5));
        assertEquals("Hello Neo! from Grpc", reply.getGreeting());
    }

}
