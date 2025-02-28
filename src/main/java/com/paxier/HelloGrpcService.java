package com.paxier;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService implements HelloWorldService {
    @Override
    public Uni<HelloWorldResponse> helloWorld(HelloWorldRequest request) {
        return Uni.createFrom().item("Hello " + request.getName() + "!")
                .map(msg -> HelloWorldResponse.newBuilder().setGreeting(msg).build());
    }
}
