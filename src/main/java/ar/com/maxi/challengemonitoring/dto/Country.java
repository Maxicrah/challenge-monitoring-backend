package ar.com.maxi.challengemonitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private Name name;
    private Flag flag;

    @Data @AllArgsConstructor
    @NoArgsConstructor
    public static class Name {
        private String shortname;
    }

    @Data @AllArgsConstructor
    @NoArgsConstructor
    public static class Flag{
        private OfficialFlag officialflag;
    }
    @Data @AllArgsConstructor
    @NoArgsConstructor
    public static class OfficialFlag{
        private String svg;
        private String png;
    }

}

