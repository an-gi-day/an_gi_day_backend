package com.bqtankiet.angiday.application.user.usecase;

import com.bqtankiet.angiday.application.base.UseCase;
import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.domain.user.IUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author bqtankiet
 */
@Service
public class GetUserById implements UseCase<GetUserById.Input, GetUserById.Output> {

    private final IUserRepository userRepository;
    private Long id;

    @Autowired
    public GetUserById(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Output call() {
        var result = userRepository.findById(id);
        if (result.isPresent()) {
            return new Output(result.get());
        } else {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public GetUserById with(Input input) {
        id = input.id;
        return this;
    }

    public GetUserById withId(Long id) {
        this.id = id;
        return this;
    }

    public record Input(Long id) implements InputModel{}
    public record Output(User user)  implements OutputModel{}

}
