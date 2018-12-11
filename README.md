# benchmark

Project to compare libs.

## How to use

```bash
./gradlew -stop
./gradlew jmh
```

Benchmark result is saved to build/reports/jmh/results.txt.

## ULID Benchmark

On 2,7 GHz Intel Core i7, ubuntu 16.04 LTS and Java 1.8.0_191:

```bash
Benchmark                                            Mode  Cnt        Score       Error  Units
UlidBenchmark.azamUlidRandomThroughput              thrpt   20  8021825.469 ± 80251.533  ops/s
UlidBenchmark.sulkyUlidNextULIDThroughput           thrpt   20  1416611.200 ± 42187.004  ops/s
UlidBenchmark.sulkyUlidNextValuetoStringThroughput  thrpt   20  1475542.998 ± 15265.980  ops/s
UlidBenchmark.uuidRandomUUIDtoStringThroughput      thrpt   20  1430689.366 ± 15299.126  ops/s
UlidBenchmark.azamUlidRandomAverage                  avgt   20      124.505 ±     1.034  ns/op
UlidBenchmark.sulkyUlidNextULIDAverage               avgt   20      669.598 ±    10.322  ns/op
UlidBenchmark.sulkyUlidNextValuetoStringAverage      avgt   20      726.656 ±     3.758  ns/op
UlidBenchmark.uuidRandomUUIDtoStringAverage          avgt   20      698.306 ±     2.305  ns/op
```

UUID above is included as a reference value and is executing `java.util.UUID.randomUUID().toString()`.
