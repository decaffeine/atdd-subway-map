package nextstep.subway.line.application;

import nextstep.subway.line.domain.Line;
import nextstep.subway.line.domain.LineRepository;
import nextstep.subway.line.dto.LineRequest;
import nextstep.subway.line.dto.LineResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class LineService {
    private LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    public LineResponse saveLine(LineRequest request) {
        Line persistLine = lineRepository.save(request.toLine());
        return LineResponse.of(persistLine);
    }

    @Transactional(readOnly = true)
    public List<LineResponse> findAllLines() {
        List<Line> lines = lineRepository.findAll();
        return lines.stream()
                .map(LineResponse::of)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LineResponse findLineById(Long id) {
        Optional<Line> line = lineRepository.findById(id);
        return LineResponse.of(line.orElse(null));
    }

    public void updateLine(Long id, LineRequest request) {
        Optional<Line> line = lineRepository.findById(id);
        if (!line.isPresent()) {
            throw new NoSuchElementException("no line to update!");
        }
        lineRepository.save(request.toLine());
    }

    public void deleteLine(Long id) {
        lineRepository.deleteById(id);
    }

}
