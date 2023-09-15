package io.bootify.my_app.service;

import io.bootify.my_app.domain.Usermaster;
import io.bootify.my_app.model.UsermasterDTO;
import io.bootify.my_app.repos.UsermasterRepository;
import io.bootify.my_app.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class UsermasterService {

    private final UsermasterRepository usermasterRepository;

    public UsermasterService(final UsermasterRepository usermasterRepository) {
        this.usermasterRepository = usermasterRepository;
    }

    public List<UsermasterDTO> findAll() {
        final List<Usermaster> usermasters = usermasterRepository.findAll(Sort.by("id"));
        return usermasters.stream()
                .map(usermaster -> mapToDTO(usermaster, new UsermasterDTO()))
                .toList();
    }

    public UsermasterDTO get(final Long id) {
        return usermasterRepository.findById(id)
                .map(usermaster -> mapToDTO(usermaster, new UsermasterDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UsermasterDTO usermasterDTO) {
        final Usermaster usermaster = new Usermaster();
        mapToEntity(usermasterDTO, usermaster);
        return usermasterRepository.save(usermaster).getId();
    }

    public void update(final Long id, final UsermasterDTO usermasterDTO) {
        final Usermaster usermaster = usermasterRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(usermasterDTO, usermaster);
        usermasterRepository.save(usermaster);
    }

    public void delete(final Long id) {
        usermasterRepository.deleteById(id);
    }

    private UsermasterDTO mapToDTO(final Usermaster usermaster, final UsermasterDTO usermasterDTO) {
        usermasterDTO.setId(usermaster.getId());
        usermasterDTO.setUsername(usermaster.getUsername());
        return usermasterDTO;
    }

    private Usermaster mapToEntity(final UsermasterDTO usermasterDTO, final Usermaster usermaster) {
        usermaster.setUsername(usermasterDTO.getUsername());
        return usermaster;
    }

}
