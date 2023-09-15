package io.bootify.my_app.rest;

import io.bootify.my_app.model.UsermasterDTO;
import io.bootify.my_app.service.UsermasterService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/usermasters", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsermasterResource {

    private final UsermasterService usermasterService;

    public UsermasterResource(final UsermasterService usermasterService) {
        this.usermasterService = usermasterService;
    }

    @GetMapping
    public ResponseEntity<List<UsermasterDTO>> getAllUsermasters() {
        return ResponseEntity.ok(usermasterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsermasterDTO> getUsermaster(@PathVariable(name = "id") final Long id) {
        return ResponseEntity.ok(usermasterService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createUsermaster(
            @RequestBody @Valid final UsermasterDTO usermasterDTO) {
        final Long createdId = usermasterService.create(usermasterDTO);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> updateUsermaster(@PathVariable(name = "id") final Long id,
            @RequestBody @Valid final UsermasterDTO usermasterDTO) {
        usermasterService.update(id, usermasterDTO);
        return ResponseEntity.ok(id);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteUsermaster(@PathVariable(name = "id") final Long id) {
        usermasterService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
