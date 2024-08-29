package com.example.thereddit.Controllers;

import com.example.thereddit.Model.Post;
import com.example.thereddit.Repository.PostRepository;
import com.example.thereddit.Repository.UsersRepository;
import com.example.thereddit.Repository.VotesRepository;
import com.example.thereddit.Service.RedditService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(DataController.class)
public class DataControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    RedditService redditService;
    @MockBean
    PostRepository postRepository;
    @MockBean
    UsersRepository usersRepository;
    @MockBean
    VotesRepository votesRepository;

    // Your test methods would go here
    // ...
    @Test
    public void wrongIdDelete() throws Exception
    {
        when(postRepository.findById(Mockito.anyLong())).thenReturn(null);

        mvc.perform(MockMvcRequestBuilders
                .delete("/api/delete/0")
                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
                .andExpect(status().is(300));
    }
    @Test
    public void rightIdDelete() throws Exception
    {
        when(postRepository.findById(Mockito.anyLong())).thenReturn(new Post());
        mvc.perform(MockMvcRequestBuilders
                        .delete("/api/delete/0")
                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
                .andExpect(status().is(200));
    }
}
