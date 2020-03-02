package kr.co.joy.eatgo.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MenuItem {
    @NonNull private String name;
}
