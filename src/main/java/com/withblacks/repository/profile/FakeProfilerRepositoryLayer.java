package com.withblacks.repository.profile;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.Profiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class FakeProfilerRepositoryLayer implements ProfilerRepositoryLayer{

    private ProfilesGenerator profilesGenerator;
    private final Iterable<Profiler> profiles;

    @Autowired
    public FakeProfilerRepositoryLayer(final ProfilesGenerator profilesGenerator) {
        this.profilesGenerator = profilesGenerator;
        this.profiles = profilesGenerator.generateProfiles(10);
    }


    @Override
    public Profiler find(final String name) throws NoSuchElementException {
        return Iterables.find(profiles, new Predicate<Profiler>() {
            @Override
            public boolean apply(final Profiler input) {
                return name.equals(input.getName());
            }
        });
    }

    @Override
    public Iterable<Profiler> findAll() {
        return profilesGenerator.generateProfiles(10);
    }

    @Override
    public Profiler find(final Long id) throws NoSuchElementException {
        return Iterables.find(profiles, new Predicate<Profiler>() {
            @Override
            public boolean apply(final Profiler input) {
                final Optional<Long> optional = Optional.of(input.getId());
                return optional.isPresent() && optional.get().equals(id);
            }
        });
    }

    @Override
    public Profiler save(final Profiler entity) throws IllegalArgumentException, NullPointerException, ClassCastException {
        return entity;
    }

    @Override
    public boolean modify(final Long id, final Profiler entity) throws NoSuchElementException, ClassCastException, IllegalArgumentException {
        return true;
    }

    @Override
    public boolean delete(final Long id) throws NoSuchElementException, UnsupportedOperationException, ClassCastException {
        return true;
    }
}
