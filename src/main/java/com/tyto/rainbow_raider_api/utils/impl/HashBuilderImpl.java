package com.tyto.rainbow_raider_api.utils.impl;


import com.tyto.rainbow_raider_api.model.enums.Algorithm;
import com.tyto.rainbow_raider_api.utils.HashBuilder;
import com.password4j.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HashBuilderImpl implements HashBuilder {

    private Algorithm algorithm;

    public HashBuilderImpl withAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    public String build(String text) {
        if (algorithm == null) {
            throw new IllegalStateException("A valid algorithm must be specified before building the hash.");
        }

        MessageDigestFunction messageDigestFunction = MessageDigestFunction.getInstance(algorithm.getName());
        return messageDigestFunction.hash(text).getResult();
    }
}
