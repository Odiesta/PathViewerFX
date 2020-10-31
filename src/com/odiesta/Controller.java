package com.odiesta;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.odiesta.PathElements.*;

public class Controller {

    @FXML
    private AnchorPane pathElementProp;
    @FXML
    private AnchorPane pathPane;
    @FXML
    private ComboBox<PathElements> elementBox;

    private Path currentPath;

    /**
     * Initialize component before starting
     */
    public void initialize() {
        // Set PathElements enum to ComboBox
        elementBox.setItems(FXCollections.observableArrayList(ARC_TO,
                CLOSE_PATH,
                CUBIC_CURVE_TO,
                H_LINE_TO,
                LINE_TO,
                MOVE_TO,
                QUAD_CURVE_TO,
                V_LINE_TO)
        );

        // Create new Path
        currentPath = new Path(new MoveTo(0.0, 0.0));
        pathPane.getChildren().add(currentPath);

        // Specify action when ComboBox value change
        elementBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            pathElementProp.getChildren().clear();
            switch (newVal) {
                case ARC_TO:
                    currentPath.getElements().add(addArcToPropThenReturn());
                    break;
                case CLOSE_PATH:
                    currentPath.getElements().add(new ClosePath());
                    break;
                case CUBIC_CURVE_TO:
                    currentPath.getElements().add(addCubicCurveToPropThenReturn());
                    break;
                case H_LINE_TO:
                    currentPath.getElements().add(addHLineToThenReturn());
                    break;
                case LINE_TO:
                    currentPath.getElements().add(addLineToThenReturn());
                    break;
                case MOVE_TO:
                    currentPath.getElements().add(addMoveToThenReturn());
                    break;
                case QUAD_CURVE_TO:
                    currentPath.getElements().add(addQuadCurveToThenReturn());
                    break;
                case V_LINE_TO:
                    currentPath.getElements().add(addVLineToThenReturn());
                    break;
            }
        });
    }

    /**
     *
     * @return ArcTo that will be displayed in pathPane
     */
    public ArcTo addArcToPropThenReturn() {
        GridPane gridpane = createGridPane();

        Label xLabel = new Label("SetX: ");
        Slider xSlider = createslider();

        Label yLabel = new Label("SetY: ");
        Slider ySlider = createslider();

        Label radiusXLabel = new Label("SetRadiusX: ");
        Slider radiusXSlider = createslider();

        Label radiusYLabel = new Label("SetRadiusY: ");
        Slider radiusYSlider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(xLabel, yLabel,
                radiusXLabel, radiusYLabel));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(xSlider, ySlider,
                radiusXSlider, radiusYSlider));

        gridpane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        ArcTo arcTo = new ArcTo();
        arcTo.xProperty().bind(xSlider.valueProperty());
        arcTo.yProperty().bind(ySlider.valueProperty());
        arcTo.radiusXProperty().bind(radiusXSlider.valueProperty());
        arcTo.radiusYProperty().bind(radiusYSlider.valueProperty());

        pathElementProp.getChildren().add(gridpane);

        return arcTo;
    }

    /**
     *
     * @return CubicCurveTo that will be displayed in pathPane
     */
    public CubicCurveTo addCubicCurveToPropThenReturn() {
        GridPane gridPane = createGridPane();

        Label xLabel = new Label("SetX: ");
        Slider xSlider = createslider();

        Label yLabel = new Label("SetY: ");
        Slider ySlider = createslider();

        Label controlX1Label = new Label("SetControlX1: ");
        Slider controlX1Slider = createslider();

        Label controlX2Label = new Label("SetControlX2: ");
        Slider controlX2Slider = createslider();

        Label controlY1Label = new Label("SetControlY1: ");
        Slider controlY1Slider = createslider();

        Label controlY2Label = new Label("SetControlY2: ");
        Slider controlY2Slider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(xLabel, yLabel,
                controlX1Label, controlX2Label, controlY1Label, controlY2Label));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(xSlider, ySlider,
                controlX1Slider, controlX2Slider, controlY1Slider, controlY2Slider));

        gridPane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        CubicCurveTo cubicCurveTo = new CubicCurveTo();
        cubicCurveTo.xProperty().bind(xSlider.valueProperty());
        cubicCurveTo.yProperty().bind(ySlider.valueProperty());
        cubicCurveTo.controlX1Property().bind(controlX1Slider.valueProperty());
        cubicCurveTo.controlX2Property().bind(controlX2Slider.valueProperty());
        cubicCurveTo.controlY1Property().bind(controlY1Slider.valueProperty());
        cubicCurveTo.controlY2Property().bind(controlY2Slider.valueProperty());

        pathElementProp.getChildren().add(gridPane);

        return cubicCurveTo;
    }

    /**
     *
     * @return HLineTo that will be displayed in pathPane
     */
    public HLineTo addHLineToThenReturn() {
        GridPane gridPane = createGridPane();

        Label xLabel = new Label("SetX: ");
        Slider xSlider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(xLabel));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(xSlider));

        gridPane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        HLineTo hLineTo = new HLineTo();
        hLineTo.xProperty().bind(xSlider.valueProperty());

        pathElementProp.getChildren().add(gridPane);

        return hLineTo;
    }

    /**
     *
     * @return LineTo that will be displayed in pathPane
     */
    public LineTo addLineToThenReturn() {
        GridPane gridPane = createGridPane();

        Label xLabel = new Label("SetX: ");
        Slider xSlider = createslider();

        Label yLabel = new Label("SetY: ");
        Slider ySlider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(xLabel, yLabel));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(xSlider, ySlider));

        gridPane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        LineTo lineTo = new LineTo();
        lineTo.xProperty().bind(xSlider.valueProperty());
        lineTo.yProperty().bind(ySlider.valueProperty());

        pathElementProp.getChildren().add(gridPane);

        return lineTo;
    }

    /**
     *
     * @return MoveTo that will be displayed in pathPane
     */
    public MoveTo addMoveToThenReturn() {
        GridPane gridPane = createGridPane();

        Label xLabel = new Label("SetX: ");
        Slider xSlider = createslider();

        Label yLabel = new Label("SetY: ");
        Slider ySlider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(xLabel, yLabel));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(xSlider, ySlider));

        gridPane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        MoveTo moveTo = new MoveTo();
        moveTo.xProperty().bind(xSlider.valueProperty());
        moveTo.yProperty().bind(ySlider.valueProperty());

        pathElementProp.getChildren().add(gridPane);

        return moveTo;
    }

    /**
     *
     * @return QuadCurveTo that will be displayed in pathPane
     */
    public QuadCurveTo addQuadCurveToThenReturn() {
        GridPane gridPane = createGridPane();

        Label xLabel = new Label("SetX: ");
        Slider xSlider = createslider();

        Label yLabel = new Label("SetY: ");
        Slider ySlider = createslider();

        Label controlXLabel = new Label("SetControlX: ");
        Slider controlXSlider = createslider();

        Label controlYLabel = new Label("SetControlY: ");
        Slider controlYSlider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(xLabel, yLabel,
                controlXLabel, controlYLabel));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(xSlider, ySlider,
                controlXSlider, controlYSlider));

        gridPane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.xProperty().bind(xSlider.valueProperty());
        quadCurveTo.yProperty().bind(ySlider.valueProperty());
        quadCurveTo.controlXProperty().bind(controlXSlider.valueProperty());
        quadCurveTo.controlYProperty().bind(controlYSlider.valueProperty());

        pathElementProp.getChildren().add(gridPane);

        return quadCurveTo;
    }

    /**
     *
     * @return VLineTo that will be displayed in pathPane
     */
    public VLineTo addVLineToThenReturn() {
        GridPane gridPane = createGridPane();

        Label yLabel = new Label("SetY: ");
        Slider ySlider = createslider();

        List<Label> labels = new ArrayList<>(Arrays.asList(yLabel));
        List<Slider> sliders = new ArrayList<>(Arrays.asList(ySlider));

        gridPane.getChildren().addAll(setGridRowAndColumn(labels, sliders));

        VLineTo vLineTo = new VLineTo();
        vLineTo.yProperty().bind(ySlider.valueProperty());

        pathElementProp.getChildren().add(gridPane);

        return vLineTo;
    }

    /**
     *
     * @return new Gridpane with initial property
     */
    public GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        return gridPane;
    }

    /**
     * Arrange row and column for Label and Slider in chosen PathElement
     * @param labels The description of property
     * @param sliders The control of certain property
     * @return
     */
    public ObservableList<Node> setGridRowAndColumn(List<Label> labels, List<Slider> sliders) {
        ObservableList<Node> nodes = FXCollections.observableArrayList();
        AtomicInteger row = new AtomicInteger();
        int column = 0;

        labels.forEach(label -> {
            GridPane.setRowIndex(label, row.get());
            GridPane.setColumnIndex(label, column);
            row.incrementAndGet();
        });
        row.set(0);
        sliders.forEach(slider -> {
            GridPane.setRowIndex(slider, row.get());
            GridPane.setColumnIndex(slider, column + 1);
            row.incrementAndGet();
        });

        nodes.addAll(labels);
        nodes.addAll(sliders);

        return nodes;
    }

    /**
     *
     * @return Slider with initial property
     */
    public Slider createslider() {
        Slider slider = new Slider();
        slider.setMax(1000);
        slider.setMin(0);
        slider.setBlockIncrement(0.5);

        return slider;
    }

    /**
     * Clear the Path in pathPane then add MoveTo element
     */
    @FXML
    public void clearPath() {
        currentPath.getElements().clear();
        currentPath.getElements().add(new MoveTo(0.0, 0.0));
    }

}
