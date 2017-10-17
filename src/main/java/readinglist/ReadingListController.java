package readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public  ReadingListController(ReadingListRepository readingListRepository){
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    //@PathVariable("reader") 把url中的占位符参数传到方法形参中
    public  String readerBooks(@PathVariable("reader") String reader, Model model){
        List<Book> readinglist = readingListRepository.findByReader(reader);
        if(readinglist!=null) {
            model.addAttribute("books", readinglist);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}",method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader")String reader,Book book){
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
}