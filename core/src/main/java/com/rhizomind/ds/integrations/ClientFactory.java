package com.rhizomind.ds.integrations;

@FunctionalInterface
public interface ClientFactory {
    <T> T create(
            Class<T> clientClazz);
}
