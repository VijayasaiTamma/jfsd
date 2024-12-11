package Lodge;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LodgeService {

    @Autowired
    private LodgeRepository lodgeRepository;

    public List<Lodge> getAllLodges() {
        return lodgeRepository.findAll();
    }

    public Optional<Lodge> getLodgeById(Long id) {
        return lodgeRepository.findById(id);
    }

    public Lodge saveLodge(Lodge lodge) {
        return lodgeRepository.save(lodge);
    }

    public void deleteLodge(Long id) {
        lodgeRepository.deleteById(id);
    }
}
