package net.cactusthorn.config.core;

import static net.cactusthorn.config.core.Disable.Feature.*;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.SortedSet;

import net.cactusthorn.config.core.converter.ConverterClass;
import net.cactusthorn.config.core.converter.ToTestConverter;

@Config @Prefix("test") public interface TestConfig {

    @Disable(PREFIX) @Default("ddd") String aaa();

    @Key("string") String str();

    @Disable(PREFIX) Optional<String> ostr();

    Optional<String> ostr1();

    @Default("A") String dstr();

    @Default("B") String dstr2();

    List<String> list();

    Optional<List<String>> olist();

    Optional<List<String>> olist2();

    @Default("A,A") List<String> dlist();

    @Default("B,B") List<String> dlist2();

    Set<String> set();

    Optional<Set<String>> oset();

    Optional<Set<String>> oset2();

    @Default("A,A") Set<String> dset();

    @Default("B,B") Set<String> dset2();

    SortedSet<String> sort();

    Optional<SortedSet<String>> osort();

    Optional<SortedSet<String>> osort2();

    @Default("A,A") SortedSet<String> dsort();

    @Default("B,B") SortedSet<String> dsort2();

    Optional<Duration> duration();

    @ConverterClass(ToTestConverter.class) @Default("default") String testconverter();
}
