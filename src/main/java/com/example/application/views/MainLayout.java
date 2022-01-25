package com.example.application.views;

import com.example.application.views.list.ListView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

// AppLayout is a Vaadin layout with a header and responsive drawer.
public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(
                // DrawerToggle is a menu button that toggles the visibility of the sidebar.
                new DrawerToggle(),
                logo);

        // Centers the components in the header.
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
    }

    private void createDrawer() {
        // Creates a RouterLink with the text "List" and the ListView.class as the
        // destination.
        RouterLink listLink = new RouterLink("List", ListView.class);
        // Avoid highlighting the link for partial route matches.
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

        // Wraps the link in a Vertical Layout and adds it to the Applayout's drawer.
        addToDrawer(new VerticalLayout(listLink, new RouterLink("DashBoard", DashboardView.class)));
    }
}
