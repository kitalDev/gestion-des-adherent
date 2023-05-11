package com.example.gestionAdherents.service.impl;

import com.example.gestionAdherents.domain.RoleUtilisateur;
import com.example.gestionAdherents.domain.Utilisateur;
import com.example.gestionAdherents.repository.RoleRepository;
import com.example.gestionAdherents.repository.UtilisateurRepository;
import com.example.gestionAdherents.security.JwtUtils;
import com.example.gestionAdherents.service.IUtilisateurService;
import com.example.gestionAdherents.service.dto.AuthentificationRequest;
import com.example.gestionAdherents.service.dto.AuthentificationResponse;
import com.example.gestionAdherents.service.dto.UtilisateurDTO;
import com.example.gestionAdherents.service.mapper.IUtilisateurMapper;
import com.example.gestionAdherents.validation.ObjectValidator;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
    public static final String ROLE_USER = "ROLE_USER";
    public static final String ROLE_USER1 = "ROLE_USER";
    private final UtilisateurRepository repository;
    private final RoleRepository roleRepository;
    private final IUtilisateurMapper mapper;
    private final ObjectValidator<UtilisateurDTO> validator;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public UtilisateurServiceImpl(
            UtilisateurRepository repository,
            IUtilisateurMapper mapper,
            ObjectValidator<UtilisateurDTO> validator,
            RoleRepository roleRepository,
            RoleRepository roleRepository1, PasswordEncoder passwordEncoder, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
        this.roleRepository = roleRepository1;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
    }

    /**
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public String save(UtilisateurDTO dto) {
        validator.validate(dto);
        Utilisateur utilisateur= mapper.toEntity(dto);
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        return repository.saveAndFlush(
                utilisateur
        ).getId();
    }

    /**
     * @return
     */
    @Override
    public List<UtilisateurDTO> findAll() {
        return mapper.toDto(
                repository.findAll()
        );
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UtilisateurDTO findById(String id) {
        return mapper.toDto(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Aucun Utilisateur de id "+id+" n'est trouvé"))
        );
    }

    /**
     * @param id
     */
    @Override
    @Transactional
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    /**
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public AuthentificationResponse register(UtilisateurDTO dto) {
        validator.validate(dto);
        Utilisateur utilisateur= mapper.toEntity(dto);
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateur.setRole(
                findRoleByNom(ROLE_USER1)
        );
        Utilisateur savedUtilisateur= repository.saveAndFlush(utilisateur);

        Map<String, Object> claims = new HashMap<>();
        claims.put("utilisateurId", savedUtilisateur.getId());
        claims.put("fullname", savedUtilisateur.getPrenom()+" "+savedUtilisateur.getNom());
        String token= jwtUtils.generateToken(savedUtilisateur, claims);
        return AuthentificationResponse.builder()
                .token(token)
                .build();
    }

    /**
     * @param authentificationRequest
     * @return
     */
    @Override
    public AuthentificationResponse authenticate(AuthentificationRequest authentificationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authentificationRequest.getEmail(),
                        authentificationRequest.getPassword()
                )
        );
        final Utilisateur userDetails = repository.findByEmail(authentificationRequest.getEmail()).get();
        Map<String, Object> claims = new HashMap<>();
        claims.put("utilisateurId", userDetails.getId());
        claims.put("fullname", userDetails.getPrenom()+" "+userDetails.getNom());
        final String token= jwtUtils.generateToken(userDetails, claims);
        return AuthentificationResponse.builder()
                .token(token)
                .build();
    }

    private RoleUtilisateur findRoleByNom(String nomRole){
        RoleUtilisateur roleUtilisateur= roleRepository.findByNom(nomRole).orElse(null);
        if (roleUtilisateur ==null){
            return roleRepository.saveAndFlush(
                    RoleUtilisateur.builder()
                            .nom(nomRole)
                            .build()
            );
        }
        return roleUtilisateur;
    }
}
