package io.github.twibap;

public class PrimePager {

    private static final int AMOUNT_PER_PAGE = (80000000 / 4); // 80MB / 4B

    private final int target;
    private final int totalPage;
    private int page = 0;

    public PrimePager(int target) {
        this.target = target;
        this.totalPage = (target / AMOUNT_PER_PAGE) / 2;    // 홀수만
        System.out.println("Total page is "+totalPage);
    }

    public int[] getPage() {
        if (page > totalPage)
            return null;

        System.out.println("Page "+page);

        int[] chapter;
        if (totalPage == 0)
            chapter = new int[target / 2];
        else if (page < totalPage)
            chapter = new int[AMOUNT_PER_PAGE];
        else
            chapter = new int[(target - (AMOUNT_PER_PAGE * (page + 1))) / 2];

        for (int i = chapter.length * page++; i < chapter.length * page; i++) {
            if (i == 0) {
                chapter[i] = 2;
                continue;
            }

            int value = 2 * (i - 1) + 3;
            if (value >= target) {
                return chapter;
            }

            chapter[i - (AMOUNT_PER_PAGE * (page - 1))] = value;
        }

        return chapter;
    }

}
