expected = read.csv2("../expected-results/results.csv", sep=";")
actual = subset(read.csv2("../output/output.csv", sep=";"), MetricName=="Problems")

tools = unique(actual$Tool)

for (tool in tools) {
  tool_data = subset(actual, Tool==tool)
  mutant_sets = unique(tool_data$MutantSet)
  for (mutant_set in mutant_sets) {
    mset_data = subset(tool_data, MutantSet==mutant_set)
    sources = unique(mset_data$Source)
    for (msource in sources) {
      source_data = subset(mset_data, Source==msource)
      source_n = length(row.names(source_data))

      for (i in 1:source_n) {
        query.row = source_data[i,]

        # By using as.character in Source, we don't need to have run all sources to run the comparison
        expected.row = subset(expected,
                              MutantSet == query.row$MutantSet
                              & as.character(Source)==as.character(query.row$Source)
                              & Mutant==query.row$Mutant)

        if (length(as.character(expected.row$MetricValue)) > 0) {
          actual_consistent = ifelse(query.row$MetricValue == 0, "consistent", "not consistent");
          expected_consistent = ifelse(expected.row$MetricValue == 0, "consistent", "not consistent");
          if (actual_consistent != expected_consistent) {
            print(paste(tool, "is wrong. Was",
                        actual_consistent, "(", query.row$MetricValue, ") but expected",
                        expected_consistent, "(", expected.row$MetricValue, ") for mutant set",
                        mutant_set, "source", msource,
                        "mutant", query.row$Mutant,
                        "run", query.row$RunIndex))
          }
        } else {
          print(paste("Warning:", tool, "produced the result", actual_consistent,
                      "(", query.row$MetricValue, ")",
                      "but expected result is unavailable for mutant set", mutant_set,
                      "source", msource, "mutant", query.row$Mutant,
                      "run", query.row$RunIndex))
        }

      }
    }

  }
}
