package controller;

/**
 * Created by BurakMac on 21/12/15.
 */
import model.Node;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import request.RouteGetRequest;
import response.RouteGetResponse;
import utils.GraphCreator;
import utils.OutputManager;
import utils.PGMReader;
import utils.algorithms.AstarAlgorithm;

import java.io.IOException;
import java.util.Stack;

@RestController
public class RouteController {

    @RequestMapping(value = "/route", method = RequestMethod.POST)
    public RouteGetResponse getRoute(@RequestBody RouteGetRequest request) {
        RouteGetResponse routeGetResponse = new RouteGetResponse();
    try{
        if(request == null)
        {
            routeGetResponse.setResultCode(67);
            routeGetResponse.setMessage("Route request is null.");
        }

        PGMReader pgmReader = new PGMReader();
        OutputManager outputManager = new OutputManager();
            GraphCreator graphCreator = new GraphCreator(pgmReader.readFile());
            graphCreator.print();
            AstarAlgorithm astar = new AstarAlgorithm();
            Stack<Node> path = astar.Search(graphCreator.getData()[request.getFromX()][request.getFromY()], graphCreator.getData()[request.getToX()][request.getToY()]);
            outputManager.setPath(path);
            outputManager.write();

            while(path.size()>0)
            {
                Node node = path.pop();
                graphCreator.getData()[node.getX()][node.getY()].setPath(true);
            }
            System.out.println();
            System.out.println();
            graphCreator.print();


            routeGetResponse.setResultCode(58);

        System.out.println("dlajshdja");


    }
    catch (Exception ex)
    {
        routeGetResponse.setResultCode(67);
        routeGetResponse.setMessage("Finding route operation failed.");
        ex.printStackTrace();
    }
        return routeGetResponse;
    }

}