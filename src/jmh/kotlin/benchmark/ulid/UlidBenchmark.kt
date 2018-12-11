package benchmark.ulid

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.BenchmarkMode
import org.openjdk.jmh.annotations.Mode
import org.openjdk.jmh.annotations.OutputTimeUnit
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import java.util.UUID
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
open class UlidBenchmark {

    private lateinit var sulkyUlid: de.huxhorn.sulky.ulid.ULID

    @Setup
    fun init() {
        sulkyUlid = de.huxhorn.sulky.ulid.ULID()
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    fun sulkyUlidNextULIDThroughput(): String {
        return sulkyUlid.nextULID()
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun sulkyUlidNextULIDAverage(): String {
        return sulkyUlid.nextULID()
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    fun sulkyUlidNextValuetoStringThroughput(): String {
        return sulkyUlid.nextValue().toString()
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun sulkyUlidNextValuetoStringAverage(): String {
        return sulkyUlid.nextValue().toString()
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    fun azamUlidRandomThroughput(): String {
        return io.azam.ulidj.ULID.random()
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun azamUlidRandomAverage(): String {
        return io.azam.ulidj.ULID.random()
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.SECONDS)
    fun uuidRandomUUIDtoStringThroughput(): String {
        return UUID.randomUUID().toString()
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    fun uuidRandomUUIDtoStringAverage(): String {
        return UUID.randomUUID().toString()
    }
}
