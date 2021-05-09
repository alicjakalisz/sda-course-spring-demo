package pl.sda.javalondek4springdemo.service.github;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubRestService {
    private static final Logger logger = LoggerFactory.getLogger(GitHubRestService.class);

    private final RestTemplate restTemplate;
    private final String gitHubUser;

    public GitHubRestService(RestTemplate restTemplate,@Value("${github.user}") String gitHubUser,
                             @Value("${magic.value:42}")int magicValue) {
        this.restTemplate = restTemplate;
        this.gitHubUser = gitHubUser;


        logger.info("github user: [{}]",gitHubUser);
        logger.info("magic value: [{}]",magicValue);
    }
    public String findMyReposAsString() {
        return "";
    }
}
