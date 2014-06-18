package algorithmDesignManual.chapter6.S6_5;

public class edgenode {
    int v; /* neighboring vertex */
    int capacity;  /* capacity of edge */
    int flow;      /* flow through edge */
    int residual;  /* residual capacity of edge */
    edgenode next; /* next edge in list */
}
