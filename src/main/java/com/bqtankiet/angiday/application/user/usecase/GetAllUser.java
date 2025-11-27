package com.bqtankiet.angiday.application.user.usecase;

import com.bqtankiet.angiday.application.base.UseCase;
import com.bqtankiet.angiday.domain.user.User;
import com.bqtankiet.angiday.domain.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllUser implements UseCase<GetAllUser.MaskFlag, GetAllUser.Output> {

    private final IUserRepository userRepository;
    private MaskFlag flag;

    @Autowired
    public GetAllUser(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Output call() {
        List<User> users = userRepository.findAll();
        if (flag == MaskFlag.SHOW_ALL) {
            return new Output(users);
        }
        if (flag == MaskFlag.MASK_EMAIL_PHONE) {
            users.forEach(u -> {
                u.setEmail(u.getMaskedEmail());
                u.setPhone(u.getMaskedPhone());
            });
            return new Output(users);
        }
        return new Output(userRepository.findAll());
    }

    @Override
    public GetAllUser with(MaskFlag flag) {
        this.flag = flag;
        return this;
    }

    public record Output(List<User> users) implements OutputModel{}

    public enum MaskFlag implements InputModel {
        MASK_EMAIL_PHONE,
        SHOW_ALL
    }
}
