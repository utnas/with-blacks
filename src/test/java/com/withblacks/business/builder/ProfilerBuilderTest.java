package com.withblacks.business.builder;

import com.withblacks.business.entity.Profiler;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static com.withblacks.business.builder.ProfilerBuilder.build;
import static org.junit.Assert.assertThat;

public class ProfilerBuilderTest {

    @Test
    public void testBuild() throws Exception {
        assertThat(build("My Name", "My language", "My Description"),
                hasProperties("My Name", "My language", "My Description"));
    }

    public static Matcher<Profiler> hasProperties(final String name, final String language, final String description) {
        return new BaseMatcher<Profiler>() {
            @Override
            public boolean matches(Object item) {
                final Profiler profiler = (Profiler) item;
                return profiler.getName().equals(name)
                        && profiler.getLanguage().equals(language)
                        && profiler.getDescription().equals(description);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

}