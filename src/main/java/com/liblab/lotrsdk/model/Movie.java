package com.liblab.lotrsdk.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonPropertyOrder({"_id"})
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("_id")
    private String id;
    private String name;
    private int runtimeInMinutes;
    private int budgetInMillions;
    private int boxOfficeRevenueInMillions;
    private int academyAwardNominations;
    private int academyAwardWins;
    private int rottenTomatoesScore;
    private List<String> quotes;

    public class MovieCriteria {

        private Enum<MovieCriteria.Symbol> Symbol;

        public MovieCriteria(String attributeName, Enum<Symbol> symbolEnum, int value){
            this.attributeName = attributeName;
            this.value = value;
            this.Symbol = symbolEnum;
        }

        /**
         * attributes like runtimeInMinutes, budgetInMillions etc.
         */
        private String attributeName;
        /**
         * String to signify symbol for e.g. <, >, >=
         */
        public enum Symbol {
            LESS_THAN {
                public String toString() {
                    return "<";
                }
            },

            GREATER_THAN {
                public String toString() {
                    return ">";
                }
            },
            GREATER_THAN_OR_EQUALS {
                public String toString() {
                    return ">=";
                }
            }
        }
        /**
         * attribute value will be 100, for e.g budgetInMillions < 100
         */
        private int value;

        public String getCriteria(){
            StringBuilder builder = new StringBuilder();
            builder.append("&");
            builder.append(attributeName);
            builder.append(Symbol.name());
            builder.append(value);
            return builder.toString();
        }

    }

}
