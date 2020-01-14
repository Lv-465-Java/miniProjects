package service.impl;

import dao.DaoCRUD;
import dao.impl.PosterDaoImpl;
import entity.Poster;
import exception.Message;
import exception.NotFoundException;
import service.PosterService;

public class PosterServiceImpl implements PosterService, Message {

    private final DaoCRUD<Poster> daoCRUD;

    public PosterServiceImpl() {
        daoCRUD= new PosterDaoImpl();
    }

    @Override
    public boolean save(Poster poster) {
        if (daoCRUD.insert(poster)){
            return true;
        } else {
            throw new NotFoundException(CREATE_PLACE_EXCEPTION_MESSAGE);
        }
    }
}
