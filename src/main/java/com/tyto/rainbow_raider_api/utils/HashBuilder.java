package com.tyto.rainbow_raider_api.utils;

import com.tyto.rainbow_raider_api.model.enums.Algorithm;
import com.tyto.rainbow_raider_api.utils.impl.HashBuilderImpl;

public interface HashBuilder {
    HashBuilderImpl withAlgorithm(Algorithm algorithm);
    String build(String text);
}
