package com.caiopfaltzgraff.lecaru.dto.Menu;

import java.util.List;

public record MenuData(
        List<MenuProduct> products,
        List<MenuCategory> categories,
        List<MenuSubcategory> subcategories
) {}
