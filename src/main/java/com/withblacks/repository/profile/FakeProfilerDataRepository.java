package com.withblacks.repository.profile;

import com.google.common.base.Predicate;
import com.google.common.base.Throwables;
import com.google.common.collect.Iterables;
import com.withblacks.business.entity.Profiler;
import com.withblacks.business.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class FakeProfilerDataRepository {

    private List<Profiler> repository = newArrayList();

    public FakeProfilerDataRepository() {
        ProfilesGenerator profileGenerator = new ProfilesGenerator();
        repository.addAll((Collection<Profiler>) profileGenerator.generateProfiles(20));
    }

    public List<Profiler> getProfilers() {
        return repository;
    }

    public boolean addUser(final Profiler profiler) throws IllegalArgumentException, NullPointerException, ClassCastException {
        if (repository.contains(profiler)) {
            throw Throwables.propagate(new IllegalArgumentException());
        }
        return repository.add(profiler);
    }

    public Profiler findProfiler(final Profiler profiler) throws NoSuchElementException {
        return getProfiler(profiler);
    }

    public boolean remove(final User fakeUser) throws NullPointerException, UnsupportedOperationException, ClassCastException {
        return repository.remove(fakeUser);
    }

    private Profiler getProfiler(final Profiler profiler) throws NoSuchElementException {
        return Iterables.find(repository, new Predicate<Profiler>() {
            public boolean apply(Profiler input) {
                return profiler.getId().equals(input.getId()) ||
                        profiler.getName().equals(input.getName());
            }
        });
    }
}